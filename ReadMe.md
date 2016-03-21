# effective Java
****

## 1.创建和销毁对象

**01.考虑用静态工厂方法代替构造器**

静态工厂方法与构造器相比的优势：
+ 他们有名称
+ 不必每次调用的时候都创建一个新的对象
+ 可以返回原类型的任何子类型的对象
+ 在创建参数化类型实例的时候，代码更加简洁

静态工厂方法的缺点：
+ 类如果不含public或者protected 构造器，就不能被子类化
+ 与其它静态方法没有任何区别

**02.遇到多个构造参数的时候考虑使用构建器**

多个构造参数的类的选择
+ 重叠构造器模式：模式可行，但是遇到愈多参数的时候，代码难以编写，阅读
+ JavaBean模式：构造过程中可能处于不一致的状态，且阻止了将类做成不能变的可能。
+ Builder模式：最佳选择，弥补`Class.newInstance`破坏编译时检查异常的不足

**03.用私有构造器或者枚举强化Singleton属性**

实现Singleton的方法：
+ 公有静态成员是个 final 域
+ 公有成员是个静态工厂方法
+ 单元素的枚举类型：最佳方法，无偿提供序列化机制，绝对阻止多次实例化

**04.通过私有构造器强化不可实例化的能力**

+ 企图通过将类做成抽象类强制该类不可实例化，是行不通的
+ 添加显式的私有构造器

**05.避免创建不必要的对象**

+ 操作字符串，使用StringBuilder代替 +
+ 使用静态工厂方法
+ 静态的初始化器
+ 优先使用基本类型，当心无意识的自动装箱

**06.消除过期的对象引用**

+ 清空对象引用应该是一种例外而不是规范，最佳方式是让包含引用的变量结束其生命周期，即最紧凑作用域范围内定义每一个变量
+ 只要类是自己管理内存的，应当警惕内存泄漏问题，一旦元素被释放，则该元素中包含的任何对象应用都应该被清空

内存泄漏的常见来源：
+ 自己管理内存的类，比如栈
+ 缓存
+ 监听器和其他回调

**07.避免使用finalizer方法**
+ finalizer方法不可预测，危险，也是不必要的
+ finalizer方法有一个严重的性能损失
+ 使用显式的终止方法代替，通常与try-finally结构集合使用，确保及时终止

> 常见的InputStream,OutputStream,java.sql.Connection上的close方法，java.util.Timer的cancel方法

终结方法的优势：
+ 当对象的所有者调用显式的终止方法时，可以充当安全网

## 2.对于所有对象都通用的方法

**08.覆盖equals时请遵守通用约定**

应该覆盖equals方法的任一条件：
+ 类的每个实例的本质上都是唯一的
+ 不关心类是否提供了逻辑相等的测试功能
+ 超类已经覆盖了equals,从超类集成过来的行为对于子类也是合适的
+ 类是私有或者包级私有的，可以确定它的equals方法，

>equals实现了等价关系：
+ 自反性：对任何非null的引用值x,x.equals(x)必须返回true
+ 对称性：对于任何非null的引用x\y,当且仅当y.equals(x)返回true时，x.equals(y)必须返回true
+ 传递性：对于任何非null的引用值x\y\z,如果x.equals(y)返回true且y.equals(z)也返回true,那么x.equals(z)也必须返回true
+ 一致性：对于任何非null的引用值x\y,只要equals的比较操作的在对象中所用的信息没有被修改，多次调用x.equals(y)就会一致地返回true或者false.
+ 对于任何非null的引用值x,x.equals(null)必须返回false;

equals方法诀窍：

1. 使用==操作符检查“参数是否为这个对象的引用”
2. 使用instanceof操作符检查"参数是否为正确的类型"
3. 把参数转换成正确的类型
4. 对于该类中的每个关键域，检查参数中的域是否与该对象中的域相匹配
5. 完成编写equals方法后确认，对称性，一致性，传递性

**告诫**:
+ 覆盖equals时总要覆盖hashCode
+ 不要企图让equals过于智能
+ 不要将equals声明中的Object对象替换为其他类型

**09.覆盖equals时总要覆盖hashCode**
+ 相等的对象必须有相等的hashCode
+ 不要试图从散列码计算中排除掉一个对象的关键部分来提高性能

**10.始终覆盖toString**
+ 提供好的toString实现可以是类看起来更加舒适
+ toString方法返回包括所有值的关键信息

**11.谨慎的覆盖clone**
> 不要让客户做任何类库能替客户完成的事情

+ 如果你覆盖了非final类中的clone方法，则应返回一个通过调用super.clone而得到的对象
+ 对于实现了Cloneable的类，也期望提供一个功能适当的共有的clone方法
+ 实际上clone方法就是另一个构造器：你必须确保它不会伤害原始的对象，并确保正确的创建被克隆对象的约束条件
+ 如果实现了Cloneable接口，必须实现一个行文良好的clone方法，否则，最好提供某些其它的方式代替对象拷贝，或者干脆不提供这样的功能。比如final类
+ 另一个实现对象拷贝的好方法就是提供一个拷贝构造器

**12.考虑实现Comparable接口**

> Java 所有的值类都实现了Comparable接口
> 整数型基本类型的域使用关系操作符 > 或者 <
> 浮点型调用Float.compare或Double.compare

## 3.类和接口

**13.使类和成员的可访问性最小化**

>信息隐藏或者封装，是软件设计的基本原则。访问机制决定类、接口和成员的可访问性

+ 尽可能地使每一个类或者成员不被外界访问的
+ 类具有公有的静态final数组域或者返回这种域的方法，几乎都是错误的

> 处理方式：
> 1.私有数组，并增加公有的不可变列表
```
private static final Thing[] PRIVATE_VALUES = { ... };
public static final List<Thing> VALUES =
    Collections.unmodifiableList(Arrays.asList(PRIVATE_VALUES));
```
>2.私有数组，并增加公有方法，返回私有数组的备份
```
private static final Thing[] PRIVATE_VALUES = { ... };
public static final Thing[] values() {
return PRIVATE_VALUES.clone();
}
```

**14.在公有类中使用访问方法而非公有域**

+ 如果类可以它所在的包外部进行访问，就提供访问方法
+ 如果类是包级私有或者私有的嵌套类，直接暴露数据域没有本质的错误

15.**使不可变性最小化**

+ 不要提供任何修改对象状态的方法
+ 保证类不会被扩展
+ 使其所有域都是私有的
+ 使所有的域都成为私有的
+ 确保对于任何可变组件的互斥访问
+ 除非有很好的理由让类变成可变泪，否则都应该是不可变的
+ 如果类不能做成不可变的，仍然应该经可能的限制他的可变性
+ 除非有令人信服的理由使域编程非final的，否则要使每个域都是final的

> 不可变对象：
> + 不可不对象比较简单
> + 不可变对象本质上是线程安全的，它们不要求同步
> + 不可变对象可以自由的被共享
> + 不仅可以共享不可变对象，甚至可以共享他们的内部信息
> + 不可变对象为其他对象提供了大量的构建
> + 不可变真正唯一的缺点是：对于每个不同的值都需要一个单独的对象

**16.复合优先于继承**

+ 与方法调用不同，继承打破了封装性
+ 只有当子类真正是超类的子类型才使用与继承，符合 is-a 关系
+ 包装类可以替代继承，但不适用于回调框架

**17.要么为继承而设计，并提供文档说明，要么禁止继承**

+ 可继承的类必须有文档说明它可覆盖的方法的自用性
+ 类必须通过某种适当的钩子，才能够进入内部的工作流程中，这种形式是protected方法。
+ 对于为了继承而设计的类，唯一的测试方法就是编写子类
+ 必须在发布类之前先编写子类对类进行测试
+ 构造器绝不能调用可被覆盖的方法
+ 无论是clone还是readObject，都不可以调用可覆盖的方法，不管是直接还是间接。
+ 为了继承而设计的类，对这个类会有一些实质性的限制。
+ 对于那些并非需要继承的类需要禁止子类化

> 禁止子类化的方式：
> + 类声明为final
> + 把所有的构造器都变成私有的，或者包级私有的，并增加一些公有的静态工厂来替代构造器

**18.接口优于抽象类**

+ 现有的类很容易被更新，以实现新的接口
+ 接口定义是混合类型的理想选择
+ 接口允许我们构造非层次结构的类型框架
+ 接口使得安全地增强类的功能成为可能
+ 通过对重要接口都提供一个抽象的骨架实现类，把接口和抽象类的有点结合起来

> + 使用抽象类定义多个实现的类型，相比接口的优势：抽象类的演化要比接口的演变要容易的多
> + 接口一点被公开发行，并被广泛实现，几乎无法修改

**19.接口只用与定义类型**

+ 常量接口模式是对接口的不良使用
+ 常量应该被定义为 工具类的静态共有常量或者枚举类类型的常量
