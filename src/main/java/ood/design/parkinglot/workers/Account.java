package ood.design.parkinglot.workers;

import ood.design.parkinglot.constants.Person;
import ood.design.parkinglot.structure.AccountStatus;

/**
 * Created by George Fouche on 12/29/19.
 */
public abstract class Account {
    private String userName;
    private String password;
    private AccountStatus status;
    private Person person;


    public abstract boolean resetPassword();
}
