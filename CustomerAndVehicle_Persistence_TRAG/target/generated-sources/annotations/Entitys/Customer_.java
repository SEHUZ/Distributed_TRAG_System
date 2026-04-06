package Entitys;

import Entitys.Vehicle;
import Enums.CustomerStatus;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2026-04-06T03:05:01", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Customer.class)
public class Customer_ { 

    public static volatile SingularAttribute<Customer, String> firstName;
    public static volatile SingularAttribute<Customer, String> lastName;
    public static volatile SingularAttribute<Customer, String> secondLastName;
    public static volatile SingularAttribute<Customer, String> phoneNumber;
    public static volatile ListAttribute<Customer, Vehicle> vehicles;
    public static volatile SingularAttribute<Customer, Long> id;
    public static volatile SingularAttribute<Customer, String> email;
    public static volatile SingularAttribute<Customer, CustomerStatus> status;

}