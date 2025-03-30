package bookstore.model.states;

import bookstore.model.Customer;

public interface CustomerState {
    String getStatus();

    void checkStatus(Customer customer);
}
