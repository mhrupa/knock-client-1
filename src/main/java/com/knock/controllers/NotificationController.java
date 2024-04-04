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
public class NotificationController {

	@Autowired
	private KnockNotificationService knockNotificationService;

	@PostMapping("/notification/trigger-client1")
	public ResponseEntity<WorkflowTriggerResponse> sendMessage(
			@RequestBody WorkflowTriggerRequestDto workflowTriggerRequestDto) {
		log.info("send message called");
		WorkflowTriggerResponse response = knockNotificationService.triggerNotification(workflowTriggerRequestDto);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping("/notification/trigger-group-notifications")
	public ResponseEntity<WorkflowTriggerResponse> sendMessageToGroup(
			@RequestBody WorkflowTriggerRequestDto workflowTriggerRequestDto) {
		log.info("sendMessageToGroup message called");
		WorkflowTriggerResponse response = knockNotificationService.triggerGroupNotification(workflowTriggerRequestDto);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
