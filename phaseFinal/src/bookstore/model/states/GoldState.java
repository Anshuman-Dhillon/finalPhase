package bookstore.model.states;

import bookstore.model.Customer;

public class GoldState implements CustomerState {

    @Override
    public String getStatus() {
        return "Gold";
    }

    @Override
    public void checkStatus(Customer customer) {
        // Downgrade to Silver if points < 1000
        if (customer.getPoints() < 1000) {
            customer.setState(new SilverState());
        }
    }
}
