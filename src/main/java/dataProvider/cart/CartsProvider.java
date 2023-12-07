package dataProvider.cart;

import lombok.Data;

public interface CartsProvider {

    Cart validFirstCart = new Cart("4111111111111111", "1230", "123");
    Cart validSecondCart = new Cart("5555555555554444", "1230", "123");

    class Cart {
        private final String number;
        private final String expiration;
        private final String cvv;

        Cart(String number, String expiration, String cvv) {
            this.number = number;
            this.expiration = expiration;
            this.cvv = cvv;
        }

        public String getNumber() {
            return number;
        }

        public String getExpiration() {
            return expiration;
        }

        public String getCvv() {
            return cvv;
        }
    }
}


