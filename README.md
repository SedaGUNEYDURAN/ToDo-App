# SpringBoot Notlarım 
## Properties Dosyası
•	spring.mvc.view.suffix, dosya uzantısını belirtmek için kullanılır.  
spring.mvc.view.prefix, Spring MVC’de kullanılan bir yapılandırma ayarıdır.Diyelim ki uygulamada **/src/main/resources/META-INF/resources/WEB-INF/jsp/fileName.jsp** pathinde fileName.jsp dosyası bulunuyor. Bu dosyayı kullanabilmek için ; 

**spring.mvc.view.prefix=/WEB-INF/jsp/**  
**spring.mvc.view.suffix=.jsp**  

bilgileri properties dosyasına eklenir.Dosya adı koddan return ile dönmelidir;  

```java 
@RequestMapping("say-hello-jsp")
public String sayHelloJSP() {
return "fileName";
}
```

•	Sadece bir classın log levelını ayarlamak istersek **logging.level.** devamına classın pathini eklemeliyiz.Örneğin ;  

**logging.level.com.toDoApp.login=debug**


## Annotations
**@ResponseBody** annotation’ı, bir controller methodunun return değerin doğrudan http respondun gövdesine yazdırmaya yarar. Bu annotayion ile @Controller annotation’ı birlikte kullanılmalıdır. 

**@Controller** annotation’ı, bir classın web isteklerini bir web controller’ı olarak tanımlamak için kullanılır. Bu controllerlar http isteklerine farklı şekillerde yanıt verir. @RequestMapping(“/course”) içeren bir  metot için /course adresine gelen GET isteklerini işler.  JSON veri formatında gerçekleştirir.   

**@RequestParam**,bir controller methodunun parametrelerinin http istek parametrelerinden nasıl bağlanacağını belirler. Request parametrelerinin(localhost:8080/login?name=Seda) değerlerini controller methoduna parametre(name) olarak alır.
```java   
 	public String goToLoginPage(@RequestParam String name, ModelMap model) {
		model.put("name",name);
		return "login";
	}
```

Buradaki name jsp dosyasındaki name ile eşleşir;
```html
<html>
	<head>
		<title>Login Page </title>
	</head>
	<body>
		Welcome to the login page ${name} !
	</body>
</html>
```


## Ek Bilgiler
•	**Tomcat-embed-jasper**, java uygulamaların tam bir Tomcat sunucusu kullanmadan bile JSP işleme yetenekleri eklememizi sağlayan bir java kütüphanesidir. Spring Boot’un gömülü tomcat’ini kullanıyorsak JSP desteğini etkinleştirmek için projemize bu bağımlılığı eklemeliyiz.   
•	**Java Server Pages Expression Language(JSP EL)**, bir jsp sayfasında dinamik olarak değerleri hesaplamak ve görüntülemek için kullanılan özel bir programlama dilidir.   
•	**ModelMap**, Spring Framework’te bir model objesinin bir view’e bağlamak için kullanılan kütüphanedir. Model objesini saklamak ve view’i iletirken dinamik olarak değiştirmek için kullanılır.  Spring Framework’ün eski sürümlerinde daha yaygın olarak kullanılmaktadır. Daha yeni sürümlerde, Model classı tercih edilmektedir.   

### Log Level 
•	**OFF** tamamen bütün logların kapalı olduğu, ALL bütün loğların açık olduğu log seviyesidir.  
• 	**Trace** en detaylı bilgilerin verildiği log seviyesidir. Bu log seviyesinde harici ir log dosyası kullanımı gereklidir.   
•	**Debug** yazılımcıların en çok kullanıdığı log seviyesidir.  
•	**Info** genellikle son kullanıcılar tarafından kullanılan log seviyesidir.   
•	**Fatal** uygulamada kalıcı bir hata, çökme tehlikesi olan durumlarda basılmalıdır.    
•	Eğer bir log seviyesi tanımlarsak; tanımladığımız log seviyesi ve üzerindeki loglar görülebilirken altındakiler görülmez. Örnek; log seviyesi error ise off,
 fatal ve error seviyesi loğlar görülebilecek ancak diğer loğlar görülemeyecektir.   

