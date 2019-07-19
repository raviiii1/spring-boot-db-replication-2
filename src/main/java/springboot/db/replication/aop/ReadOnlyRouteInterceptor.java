package springboot.db.replication.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import springboot.db.replication.repository.RoutingDataSource;

@Aspect
@Component
@Order(0)
public class ReadOnlyRouteInterceptor {
	@Around("@annotation(transactional)")
	public Object proceed(ProceedingJoinPoint proceedingJoinPoint, Transactional transactional) throws Throwable {
		try {
			if (transactional.readOnly()) {
				RoutingDataSource.setReplicaRoute();
			}
			return proceedingJoinPoint.proceed();
		} finally {
			RoutingDataSource.clearReplicaRoute();
		}
	}
	
}
