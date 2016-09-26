package lt.vu.transactions;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.Stateful;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.TransactionSynchronizationRegistry;
import java.util.Date;

@Named
@Stateful
@RequestScoped
public class FirstComp {
    @Resource
    private TransactionSynchronizationRegistry tx;

    @Inject
    private SecondComp secondComp;

    @PostConstruct
    private void gimiau() {
        System.out.println(this + " born :)");
    }

    @PreDestroy
    private void tuojMirsiu() {
        System.out.println(this + " about to die :(");
    }

    //---------------------------------

    public String sayHello() {
        return toString() + " | " + new Date() + " | " + " Tx: " + tx.getTransactionKey() +
                " | Second component: " + secondComp.sayHello();
    }

}
