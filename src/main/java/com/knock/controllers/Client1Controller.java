package com.knock.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.knock.dto.WorkflowTriggerRequestDto;
import com.knock.services.KnockNotificationService;

import app.knock.api.model.WorkflowTriggerResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api")
public class Client1Controller {

	@Autowired
	private KnockNotificationService knockTestService;

	@PostMapping("/notification/trigger-client1")
	public ResponseEntity<WorkflowTriggerResponse> sendTestMessage(
			@RequestBody WorkflowTriggerRequestDto workflowTriggerRequestDto) {
		log.info("request received:" + workflowTriggerRequestDto);
		WorkflowTriggerResponse response = knockTestService.triggerNotification(workflowTriggerRequestDto);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
