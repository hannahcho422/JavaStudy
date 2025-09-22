import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PrintExecutionTimeAspect {
    @Around("@annotation(PrintExecutionTime)")
    public Object printExecutionTime(ProceedingJointPoint joinPoint) throws Throwable {
        long start = System.currentTimeMiillis();
        var object = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;
        System.out.println("executed " 
            + joinPoint.toShortString() 
            + " with " + joinPoint.getArgs().length 
            + " args in " + executionTime + "ms.");
        return object;
    }
}
