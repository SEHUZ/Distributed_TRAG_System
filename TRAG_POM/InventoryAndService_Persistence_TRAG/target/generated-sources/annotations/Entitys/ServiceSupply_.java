package Entitys;

import Entitys.Service;
import Entitys.Supply;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2026-04-05T09:12:05", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(ServiceSupply.class)
public class ServiceSupply_ { 

    public static volatile SingularAttribute<ServiceSupply, Service> service;
    public static volatile SingularAttribute<ServiceSupply, Long> id;
    public static volatile SingularAttribute<ServiceSupply, Integer> defaultQuantity;
    public static volatile SingularAttribute<ServiceSupply, Supply> supply;
    public static volatile SingularAttribute<ServiceSupply, Boolean> enabled;

}