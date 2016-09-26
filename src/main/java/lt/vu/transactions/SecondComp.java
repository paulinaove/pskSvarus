package lt.vu.transactions;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.transaction.TransactionSynchronizationRegistry;

@Stateless
public class SecondComp {
    @Resource
    private TransactionSynchronizationRegistry tx;

    @PostConstruct
    private void init() {
        System.out.println(this + " born :)");
    }

    @PreDestroy
    private void preDestroy() {
        System.out.println(this + " about to die :(");
    }

    //---------------------------------

    //@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public String sayHello() {
        return toString() + " Tx: " + tx.getTransactionKey();
    }

}
