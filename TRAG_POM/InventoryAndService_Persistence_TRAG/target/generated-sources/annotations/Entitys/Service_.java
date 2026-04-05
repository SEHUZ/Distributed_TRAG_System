package Entitys;

import Entitys.ServiceSupply;
import java.math.BigDecimal;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2026-04-05T09:12:05", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Service.class)
public class Service_ { 

    public static volatile ListAttribute<Service, ServiceSupply> serviceSupplies;
    public static volatile SingularAttribute<Service, BigDecimal> suggestedLaborCost;
    public static volatile SingularAttribute<Service, String> iconRoute;
    public static volatile SingularAttribute<Service, String> name;
    public static volatile SingularAttribute<Service, String> description;
    public static volatile SingularAttribute<Service, Long> id;
    public static volatile SingularAttribute<Service, Boolean> enabled;

}