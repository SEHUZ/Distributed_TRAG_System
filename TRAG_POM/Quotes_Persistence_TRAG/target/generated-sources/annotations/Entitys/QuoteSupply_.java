package Entitys;

import Entitys.Quote;
import java.math.BigDecimal;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2026-04-05T11:40:26", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(QuoteSupply.class)
public class QuoteSupply_ { 

    public static volatile SingularAttribute<QuoteSupply, Integer> quantityRequired;
    public static volatile SingularAttribute<QuoteSupply, Quote> quote;
    public static volatile SingularAttribute<QuoteSupply, BigDecimal> price;
    public static volatile SingularAttribute<QuoteSupply, Long> supplyId;
    public static volatile SingularAttribute<QuoteSupply, Boolean> active;
    public static volatile SingularAttribute<QuoteSupply, Long> id;

}