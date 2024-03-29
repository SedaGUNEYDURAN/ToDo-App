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

## HTML
•	Form method, HTML form gönderirken verilerin sunucuya nasıl iletileceğini belirleyen bir HTML ögesidir. Method niteliği formun içinde yer alır ve iki ana değer kabul eder;  
  	**Get** : Bu metodda form verileri URL’e eklenir ve sunucuya iletilir. Get metodu için veri boyutu(genellikle 2048 karakter) kısıtlıdır. Gizli verilerin gönderilmesinde güvenli değildir.(bilgiler URL’de açık duruyor nasıl güvenli olsun ?)   
  	**Post** : Bu yöntemde form verileri HTTP gövdesinde gizli bir şekilde sunucuya iletilir. Get metodundan farklı olarak URL’de görünmezler. Post methodu daha fazla veri gönderilmesine izin verir ve gizli verilerin iletimi için daha güvenlidir.    

•	**input type="submit"** bu elementin görevi formdaki verileri sunucuya göndermektedir. Bu element bir buton olarak karşımıza çıkar ve kullanıcının tıklamasıyla formdaki veriler işleme alınır. Butona tıklandığında veriler sunucuya gönderilir. Action özelliğinde belirtilen URL’e yönlendirilir. Metod özelliğine göre (get ve post) verileri sunucuya  iletir. 



## Ek Bilgiler
•	**Tomcat-embed-jasper**, java uygulamaların tam bir Tomcat sunucusu kullanmadan bile JSP işleme yetenekleri eklememizi sağlayan bir java kütüphanesidir. Spring Boot’un gömülü tomcat’ini kullanıyorsak JSP desteğini etkinleştirmek için projemize bu bağımlılığı eklemeliyiz.   
•	**Java Server Pages Expression Language(JSP EL)**, bir jsp sayfasında dinamik olarak değerleri hesaplamak ve görüntülemek için kullanılan özel bir programlama dilidir.   
•	**ModelMap**, Spring Framework’te bir model objesinin bir view’e bağlamak için kullanılan kütüphanedir. Model objesini saklamak ve view’i iletirken dinamik olarak değiştirmek için kullanılır.  Spring Framework’ün eski sürümlerinde daha yaygın olarak kullanılmaktadır. Daha yeni sürümlerde, Model classı tercih edilmektedir.     
•	**Front Controller Pattern**, uygulamaya gelen tüm istekleri tek bir nokta karşılama ve yönlendirme amacıyla kullanılır. Tüm istekler bir front contoller classına girer, front controller istekleri analiz eder ve ilgili işlemi gerçekleştirdikten sonra uygun controllera yönlendirir. Bu URL, komut gibi bilgilere göre yapılır. İstek işlenir ve sonucu Front Controllera döner. Front Controller sonucu işleyerek clienta döndürür.  Bu sayede istek işleme süreci merkezileştirilir ve kod tekrar ile karmaşıklık azaltılır.   
•	**Servlet**, Java’da web uygulamaları geliştirmek için kullanılan bir API’dır. HTTP isteklerini ve yanıtlarını işlemeyi sağlar. Servletler sunucu tarafında çalışır ve istemciye HTML, JSON, XML gibi formatlarda veri gönderir. Birden fazla istek işleyebilir ve her bir istek için ayrı threadler oluşturur. Servletler sayesinde dinamik web sayfaları ve tabanlı uygulamalar oluşturabiliriz.   
•	**DispatcherServlet**, Spring frameworkün web uygulamalarında kullanılan merkezi bir servlettir. Gelen http isteklerini karşılar.  İstek URL’ini analiz eder. Uygun controllerı bulur ve çalıştırır. Controllerdan gelen modeli ve viewı işler ve sonucu clienta gönderir. Web.xml dosyasında tanımlıdır.     
•	Pom.xml --> dependency management  
•	Web.xml --> define web app configuration  
•	Context.xml --> manage spring beans  
•	NFRs(Non-Functional Requirements) --> implement non functional requirement

### Log Level 
•	**OFF** tamamen bütün logların kapalı olduğu, ALL bütün loğların açık olduğu log seviyesidir.  
• 	**Trace** en detaylı bilgilerin verildiği log seviyesidir. Bu log seviyesinde harici ir log dosyası kullanımı gereklidir.   
•	**Debug** yazılımcıların en çok kullanıdığı log seviyesidir.  
•	**Info** genellikle son kullanıcılar tarafından kullanılan log seviyesidir.   
•	**Fatal** uygulamada kalıcı bir hata, çökme tehlikesi olan durumlarda basılmalıdır.    
•	Eğer bir log seviyesi tanımlarsak; tanımladığımız log seviyesi ve üzerindeki loglar görülebilirken altındakiler görülmez. Örnek; log seviyesi error ise off,
 fatal ve error seviyesi loğlar görülebilecek ancak diğer loğlar görülemeyecektir.   

