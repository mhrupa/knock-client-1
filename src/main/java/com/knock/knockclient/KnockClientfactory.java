package com.knock.knockclient;

import app.knock.api.KnockClient;

public class KnockClientfactory {

        private KnockClientfactory(){}

        private static KnockClient knockClient = KnockClient.builder()
        .apiKey("sk_test_Cn-OWbHhnJAS9SnV-IBaP1J23RSyUZtwQWRo7IgluqQ")
        .build();

        public static KnockClient getKnockClient() {
                return knockClient;
        }
}
