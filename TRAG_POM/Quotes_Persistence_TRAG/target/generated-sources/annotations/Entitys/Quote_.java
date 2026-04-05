package Entitys;

import Entitys.QuoteSupply;
import Enums.QuoteStatus;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2026-04-05T11:40:26", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Quote.class)
public class Quote_ { 

    public static volatile SingularAttribute<Quote, String> generalDiagnosis;
    public static volatile SingularAttribute<Quote, LocalDateTime> createdAt;
    public static volatile ListAttribute<Quote, QuoteSupply> quoteSupplies;
    public static volatile SingularAttribute<Quote, Long> customerId;
    public static volatile SingularAttribute<Quote, Boolean> active;
    public static volatile SingularAttribute<Quote, Long> id;
    public static volatile SingularAttribute<Quote, Long> vehicleId;
    public static volatile SingularAttribute<Quote, BigDecimal> laborPrice;
    public static volatile SingularAttribute<Quote, Long> serviceId;
    public static volatile SingularAttribute<Quote, String> vehicleStatus;
    public static volatile SingularAttribute<Quote, QuoteStatus> status;

}