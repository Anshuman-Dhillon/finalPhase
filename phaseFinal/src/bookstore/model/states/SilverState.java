package bookstore.model.states;

import bookstore.model.Customer;

public class SilverState implements CustomerState {

    @Override
    public String getStatus() {
        return "Silver";
    }

    @Override
    public void checkStatus(Customer customer) {
        // Upgrade to Gold if points >= 1000
        if (customer.getPoints() >= 1000) {
            customer.setState(new GoldState());
        }
    }
}
