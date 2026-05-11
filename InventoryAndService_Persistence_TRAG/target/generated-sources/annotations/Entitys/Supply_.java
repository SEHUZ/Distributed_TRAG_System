package Entitys;

import Entitys.Supplier;
import java.math.BigDecimal;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2026-05-11T03:43:08", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Supply.class)
public class Supply_ { 

    public static volatile SingularAttribute<Supply, BigDecimal> suggestedCost;
    public static volatile SingularAttribute<Supply, Supplier> supplier;
    public static volatile SingularAttribute<Supply, String> name;
    public static volatile SingularAttribute<Supply, Long> id;

}