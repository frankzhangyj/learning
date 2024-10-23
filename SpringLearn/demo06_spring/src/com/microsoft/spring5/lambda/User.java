package com.microsoft.spring5.lambda;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.lang.Nullable;

public class User {

    /**
     * 在参数上表示参数可以为空
     * 将nullable在方法上表示方法返回值可以为空
     */

    @Nullable
    public void add(@Nullable int a, int b) {

    }

    public static void main(String[] args) {
        // spring中手动new的对象不能加入到IOC容器中
        GenericApplicationContext context = new GenericApplicationContext();
        // 清空容器
        context.refresh();
        // 将需要创建的类加入到容器中 可以指定id
        // context.registerBean("user", User.class, "com.microsoft.spring5.lambda.User", () -> new User());

        // lambda表达式创建
        context.registerBean(User.class, () -> new User());
        User user = (User) context.getBean("com.microsoft.spring5.lambda.User");
        System.out.println(user);
    }
}
