package Entitys;

import Entitys.Customer;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2026-04-06T03:05:01", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Vehicle.class)
public class Vehicle_ { 

    public static volatile SingularAttribute<Vehicle, String> licensePlate;
    public static volatile SingularAttribute<Vehicle, Integer> year;
    public static volatile SingularAttribute<Vehicle, Boolean> active;
    public static volatile SingularAttribute<Vehicle, String> vin;
    public static volatile SingularAttribute<Vehicle, String> model;
    public static volatile SingularAttribute<Vehicle, Long> id;
    public static volatile SingularAttribute<Vehicle, String> brand;
    public static volatile SingularAttribute<Vehicle, Customer> customer;

}