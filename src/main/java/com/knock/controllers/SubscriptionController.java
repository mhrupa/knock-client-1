package com.knock.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.knock.dto.AddSubscriptionsRequestDto;
import com.knock.dto.SubscriptionGroupDto;
import com.knock.services.KnockSubscriptionService;

import app.knock.api.model.KnockObject;
import app.knock.api.model.ObjectSubscription;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api")
public class SubscriptionController {

	@Autowired
	private KnockSubscriptionService knockSubscriptionService;
	
	@PostMapping("/notification/add-subscription")
	public ResponseEntity<List<ObjectSubscription>> addSubscription(
			@RequestBody AddSubscriptionsRequestDto addSubscriptionsRequestDto) {
		log.info("request received:" + addSubscriptionsRequestDto);
		List<ObjectSubscription> response = knockSubscriptionService.addSubscription(addSubscriptionsRequestDto);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping("/notification/create-subscription-group")
	public ResponseEntity<KnockObject> createSubscriptionGroup(
			@RequestBody SubscriptionGroupDto subscriptionGroupDto) {
		log.info("request received:" + subscriptionGroupDto);
		KnockObject response = knockSubscriptionService.createSubscriptionGroup(subscriptionGroupDto);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
