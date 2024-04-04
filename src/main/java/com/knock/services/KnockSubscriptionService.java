package com.knock.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.knock.dto.AddSubscriptionsRequestDto;
import com.knock.dto.RecipientDto;
import com.knock.dto.SubscriptionGroupDto;
import com.knock.knockclient.KnockClientfactory;

import app.knock.api.model.AddSubscriptionsRequest;
import app.knock.api.model.KnockObject;
import app.knock.api.model.ObjectSubscription;

@Service
public class KnockSubscriptionService {

	public KnockObject createSubscriptionGroup(SubscriptionGroupDto subscriptionGroupDto) {
		return KnockClientfactory.getKnockClient().objects().set(subscriptionGroupDto.getCollectionName(),
				subscriptionGroupDto.getSubscriptionGroupId(), subscriptionGroupDto.getProperties());
	}

	public List<ObjectSubscription> addSubscription(AddSubscriptionsRequestDto addSubscriptionsRequestDto) {

		return KnockClientfactory.getKnockClient().objects().addSubscriptions(
				addSubscriptionsRequestDto.getCollectionName(), addSubscriptionsRequestDto.getSubscriptionGroupId(),
				buildAddSubscriptionRequest(addSubscriptionsRequestDto));

	}

	private AddSubscriptionsRequest buildAddSubscriptionRequest(AddSubscriptionsRequestDto request) {
		List<Object> recipientList = new ArrayList<Object>();

		for (RecipientDto recipient : request.getRecipients()) {
			recipientList
					.add(Map.of("id", recipient.getId(), "name", recipient.getName(), "email", recipient.getEmail()));
		}

		return AddSubscriptionsRequest.builder().recipients(recipientList).typeName(request.getTypeName())
				
				.build();

	}
}
