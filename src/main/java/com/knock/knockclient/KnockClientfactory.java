package com.knock.knockclient;

import app.knock.api.KnockClient;

public class KnockClientfactory {

        private KnockClientfactory(){}

        private static KnockClient knockClient = KnockClient.builder()
        .apiKey("sk_test_m6qEP-i50xWQEmNCpLsRmshmZnZhzNtcp6OT-OrLDSk")
        .build();

        public static KnockClient getKnockClient() {
                return knockClient;
        }
}
