package com.boot;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.boot.controller.ShipwreckController;
import com.boot.model.Shipwreck;
import com.boot.repository.ShipwreckRepository;

public class ShipwreckTest {

	@InjectMocks
	private ShipwreckController sc;
	
	@Mock
	private ShipwreckRepository shipwreckRepository;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testShipwreckGet() {
		Shipwreck sw = new Shipwreck();
		Optional<Shipwreck> sws = Optional.of(sw);	
		sws.get().setId(1L);
		when(shipwreckRepository.findById(1L)).thenReturn(sws);
		
		Shipwreck wreck = sc.get(1L);
		verify(shipwreckRepository).findById(1L);
		assertThat(wreck.getId(),equalTo(1L));
	}

}
