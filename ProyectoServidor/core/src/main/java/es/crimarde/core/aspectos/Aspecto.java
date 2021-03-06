package es.crimarde.core.aspectos;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.crimarde.model.Registro;
import es.crimarde.service.AspectService;

@Aspect
@Component
public class Aspecto {

	@Autowired AspectService servicio;
	
	@Around("execution(* es.crimarde.core.controller.*.*())")
	public Object tiempoPasado(ProceedingJoinPoint punto) throws Throwable {

		System.out.println("****Aspecto.logAroundAllMethods() : " + punto.getSignature().getName() + ": Before Method Execution");
		Long tiempo1 = System.currentTimeMillis();
        Object object;
		try {
        	object = punto.proceed();
        	Registro reg = new Registro();
        	reg.setMetodo(punto.getSignature().getName());
        	servicio.add(reg);
        } finally {
            //Do Something useful, If you have
        }
		Long tiempo2 = System.currentTimeMillis();
		Long total = tiempo2 - tiempo1;
        System.out.println("****Aspecto.logAroundAllMethods() : " + punto.getSignature().getName() + ": After Method Execution");
        System.out.format("****Aspecto.Tiempo de ejecucion transcurrido %d\n", total);

        return object;
	}
}

/*
 * 
Aspect: An aspect is a class that implements enterprise application concerns that cut across multiple classes, such as transaction management. Aspects can be a normal class configured through Spring XML configuration or we can use Spring AspectJ integration to define a class as Aspect using @Aspect annotation.
Join Point: A join point is the specific point in the application such as method execution, exception handling, changing object variable values etc. In Spring AOP a join points is always the execution of a method.
Advice: Advices are actions taken for a particular join point. In terms of programming, they are methods that gets executed when a certain join point with matching pointcut is reached in the application. You can think of Advices as Struts2 interceptors or Servlet Filters.
Pointcut: Pointcut are expressions that is matched with join points to determine whether advice needs to be executed or not. Pointcut uses different kinds of expressions that are matched with the join points and Spring framework uses the AspectJ pointcut expression language.
Target Object: They are the object on which advices are applied. Spring AOP is implemented using runtime proxies so this object is always a proxied object. What is means is that a subclass is created at runtime where the target method is overridden and advices are included based on their configuration.
AOP proxy: Spring AOP implementation uses JDK dynamic proxy to create the Proxy classes with target classes and advice invocations, these are called AOP proxy classes. We can also use CGLIB proxy by adding it as the dependency in the Spring AOP project.
Weaving: It is the process of linking aspects with other objects to create the advised proxy objects. This can be done at compile time, load time or at runtime. Spring AOP performs weaving at the runtime.


Before Advice: These advices runs before the execution of join point methods. We can use @Before annotation to mark an advice type as Before advice.
After (finally) Advice: An advice that gets executed after the join point method finishes executing, whether normally or by throwing an exception. We can create after advice using @After annotation.
After Returning Advice: Sometimes we want advice methods to execute only if the join point method executes normally. We can use @AfterReturning annotation to mark a method as after returning advice.
After Throwing Advice: This advice gets executed only when join point method throws exception, we can use it to rollback the transaction declaratively. We use @AfterThrowing annotation for this type of advice.
Around Advice: This is the most important and powerful advice. This advice surrounds the join point method and we can also choose whether to execute the join point method or not. We can write advice code that gets executed before and after the execution of the join point method. It is the responsibility of around advice to invoke the join point method and return values if the method is returning something. We use @Around annotation to create around advice methods.

Ejemplos de pointcut
@Pointcut("execution(public * *(..))")  
It will be applied on all the public methods.

@Pointcut("execution(public Operation.*(..))")  
It will be applied on all the public methods of Operation class.

@Pointcut("execution(* Operation.*(..))")  
It will be applied on all the methods of Operation class.

@Pointcut("execution(public Employee.set*(..))")  
It will be applied on all the public setter methods of Employee class.

@Pointcut("execution(int Operation.*(..))")  
It will be applied on all the methods of Operation class that returns int value.
*/