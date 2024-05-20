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

**@Service**, bir classı servis olarak işaretlemek için kullanılır ve bu classlar Spring beanler olarak kaydedilir. Spring beanler olarak kaydedildikleri için de bu classlar, dependency injection kullarak diğer spring tarafından kullanılan bileşenlere enjekte(@Autowired ya da constructor injection kullanılarak) edilebilirler. 

**@RequestMapping**, http isteği ile bir Java metodunu eşleştirir.  
		•	"value", özelliği ile hangi URL'in bu metoda yönlendirileceğini belirleyebiliriz.  
		•	"metod" özelliği ile hangi HTTP metodunun(GET, POST, PUT, DELETE vb.) kullanılacağını belirleyebiliriz.  
		•	"params" , özelliği ile URL’deki parametreleri metodun parametreleri ile eşleştirebiliriz.   
		•	"headers" , özelliği ile  HTTP istek başlıklarını eşleştirebiliriz.  
		•	"consumes" ve "produces"  özelliği ile istek ve yanıt formatlarını(JSON, XML vb.) belirleyebiliriz.  


**@SessionAttributes**, sınıfın tüm metodları tarafından erişilebilecek nesneleri belirlemek için kullanılır.

## HTML
•	Form method, HTML form gönderirken verilerin sunucuya nasıl iletileceğini belirleyen bir HTML ögesidir. Method niteliği formun içinde yer alır ve iki ana değer kabul eder;  
  	**Get** : Bu metodda form verileri URL’e eklenir ve sunucuya iletilir. Get metodu için veri boyutu(genellikle 2048 karakter) kısıtlıdır. Gizli verilerin gönderilmesinde güvenli değildir.(bilgiler URL’de açık duruyor nasıl güvenli olsun ?)   
  	**Post** : Bu yöntemde form verileri HTTP gövdesinde gizli bir şekilde sunucuya iletilir. Get metodundan farklı olarak URL’de görünmezler. Post methodu daha fazla veri gönderilmesine izin verir ve gizli verilerin iletimi için daha güvenlidir.    

•	**input type="submit"** bu elementin görevi formdaki verileri sunucuya göndermektedir. Bu element bir buton olarak karşımıza çıkar ve kullanıcının tıklamasıyla formdaki veriler işleme alınır. Butona tıklandığında veriler sunucuya gönderilir. Action özelliğinde belirtilen URL’e yönlendirilir. Metod özelliğine göre (get ve post) verileri sunucuya  iletir.  

•	**a href** hyperlink oluşturmak için kullanıilır. Bir metne ya da resme tıklanabilir bir bağlantı ekler. Aşağıdaki örnekte Manage yazısına tıklandıgında list-todos linkine gidilir. 
```html
	<div><a href="list-todos">Manage</a> your todos</div>
```  
•	**<%@ taglib**, JSP sayfasında bir tag kütüphanesini tanımlar. **prefix="c"**, tag kütüphanesine bir ön ek atar. Bu ön ek, tag kütüphanesini kullanırken kullanılacaktır. c ön ekini c:out tagini kullanmak için kullanırız. **uri="https://docs.oracle.com/javaee/5/jstl/1.1/docs/tlddocs/c/tld-summary.html"**, bu özellik tag kütüphanesinin URI'sini belirtir, tag kütüphanesinin nerede bulunacağını belirtir.
```html  
<%@ taglib prefıx="c" uri="https://docs.oracle.com/javaee/5/jstl/1.1/docs/tlddocs/c/tld-summary.html" %>  
```    
•	**th**, tablo oluştururken, tablonun başlık cellini oluştururken kullanılır. **td**, tabloya verileri eklemek için kullanılır. **tr** , tagi ile bir satır oluşturulur. **thead**, tablonun başlık satırlarını gruplandırmak için kullanılır.  

```html  
<table class="table">
	<thead>
		<tr>
			<th>id</th>
			<th>Description</th>
			<th>Target Date</th>
			<th>Is Done?</th>
		</tr>
	</thead>
	<tbody>		
		<c:forEach items="${todos}" var="todo">
			<tr>
				<td>${todo.id}</td>
				<td>${todo.description}</td>
				<td>${todo.targetDate}</td>
				<td>${todo.done}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

```
•	**hr** tagı, web sayfamızda yatay çizgi oluşturmak için kullanırız. Kapatmamıza gerek yoktur.   
•	**link href** tagı, html sayfamızı bir kaynağa bağlmak için kullanılır. **rel**, geçerli dökoman ile kaynak arasındaki ilişkiyi belirtir. **stylesheet**, bağlantılı kaynağın bir stil syfası olduğunu belirtir. **icon**, bağlantılı kaynağın bir favicon olduğunu belirtir. **script** bağlantılı kaynağın harici bir JavaScript dosyası olduğunu belirtir.   

```html
<link href="/webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" >
```
•	**script src** tagı, web sayfamızı harici bir JavaScript dosyasına bağlamak için kullanılır. Web sayfamızın davranışını tanımlayan (JavaScript) sayfa yapısı ve içeriğini tanımlayan koddan(HTML) ayırmamızı sağlar. **src**, JavaScript dosyasının URL'ini belirtir. 

```html
<script src="/webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="/webjars/jquery/1.9.1/jquery.min.js"></script>
```
•	**div class="container"**, web sayfasından belirli bir içeriği gruplamak, belirli bir genişlikte ve düzende göstermek için kullanılır. **div class="table"**, tablo verilerini düzenlemek için kullanılır. Bu sayede tablonun, stilini, botunu ve düzenini daha esnek bir şekilde kontrol etmek mümkündür.  
•	**cssClass="text-warning"**, metin rengini ayarlar. Genellikle metni sarı veya turuncu tonlara boyar. 

### Desing Pattern
•	**Construction Injection**, bir objenin bağımlılıklarının bir constructor’a geçirilmesidir.
```java 
public class Demo{ 
	
public class Book {
	private final Fiction fictionBook;

	public Book(Fiction fictionBook) {
		this.fictionBook = fictionBook;
	}
}
```


•


## Ek Bilgiler
•	**Tomcat-embed-jasper**, java uygulamaların tam bir Tomcat sunucusu kullanmadan bile JSP işleme yetenekleri eklememizi sağlayan bir java kütüphanesidir. Spring Boot’un gömülü tomcat’ini kullanıyorsak JSP desteğini etkinleştirmek için projemize bu bağımlılığı eklemeliyiz.   
•	**Java Server Pages Expression Language(JSP EL)**, bir jsp sayfasında dinamik olarak değerleri hesaplamak ve görüntülemek için kullanılan özel bir programlama dilidir.   
•	**JavaServer  Pages Standard Tag Library(JSTL)**, erb sayfalarında sıklıkla kullanılan tekrarlayan göervleri yerine getirmek için oluşturulmuş etiketlerden oluşur. Birden fazla kütüphaneden oluşan bir koleksiyondur. En çok kullanılan JSTL jkütüphaneleri; XML tags, SQL tags, format tags, core tags(if,else,for vb temel işlemler).  
•	**ModelMap**, Spring Framework’te bir model objesinin bir view’e bağlamak için kullanılan kütüphanedir. Model objesini saklamak ve view’i iletirken dinamik olarak değiştirmek için kullanılır.  Spring Framework’ün eski sürümlerinde daha yaygın olarak kullanılmaktadır. Daha yeni sürümlerde, Model classı tercih edilmektedir.     
•	**Front Controller Pattern**, uygulamaya gelen tüm istekleri tek bir nokta karşılama ve yönlendirme amacıyla kullanılır. Tüm istekler bir front contoller classına girer, front controller istekleri analiz eder ve ilgili işlemi gerçekleştirdikten sonra uygun controllera yönlendirir. Bu URL, komut gibi bilgilere göre yapılır. İstek işlenir ve sonucu Front Controllera döner. Front Controller sonucu işleyerek clienta döndürür.  Bu sayede istek işleme süreci merkezileştirilir ve kod tekrar ile karmaşıklık azaltılır.   
•	**Servlet**, Java’da web uygulamaları geliştirmek için kullanılan bir API’dır. HTTP isteklerini ve yanıtlarını işlemeyi sağlar. Servletler sunucu tarafında çalışır ve istemciye HTML, JSON, XML gibi formatlarda veri gönderir. Birden fazla istek işleyebilir ve her bir istek için ayrı threadler oluşturur. Servletler sayesinde dinamik web sayfaları ve tabanlı uygulamalar oluşturabiliriz. 
•	**DispatcherServlet**, Spring MVC framework'ün temel bir bileşenidir. Front controller olarak işlev görür.Spring uygulamasından gelen tüm HTTP isteklerini alır ve uygun şekilde (controller'a)yönlendirir, (view resolution işlemi yapar ve client'a yönlendirilecek HTML,JSON veya XML)yanıt verir.   
•	**Spring-boot-starter-validation**, veri doğrulama işlemlerini kolaylaştırmak için kullanılan bir tooldur. Bunun için de bir çok anotasyon sağlar. **@NotNull**, alanın null olamayacağını belirtir. **@Size(min=, max=)**, alanın  boyutlarını sınırlar. **@Email**, alanın geçerli bir e-posta adresi olmasını sağlar. **@Pattern** alanın belirli bir regex desenine uymasını sağlar. Doğrulamalar, Sprıng MVC ile entegre olarak controller katmanında kolayca kullanılabilir.Örneğin; **@Valid**, anotasyonu ile birlikte kullanıldığında, controller metoduna gelen veri otomatik olarak doğrulanır.   
•	**Glassfish**, developerların web uygulamalarını oluşturmak, dağıtmak ve yönetmek için gereken bir çok hizmeti tek platformda sunan açık kaynaklı bir platformdur. Bir web sitesini ziyaret ettiğimizde, bilgisayarmız sunucuya bir istek gönderir. Sunucu bu isteği işleyerek bir yanıt gönderir. Glassfish bu sunucuyu oluşturan ve yönetmemizi sağlayan yazılımdır.   
•	**DispatcherServlet**, Spring frameworkün web uygulamalarında kullanılan merkezi bir servlettir. Gelen http isteklerini karşılar.  İstek URL’ini analiz eder. Uygun controllerı bulur ve çalıştırır. Controllerdan gelen modeli ve viewı işler ve sonucu clienta gönderir. Web.xml dosyasında tanımlıdır.     
•	Pom.xml --> dependency management  
•	Web.xml --> define web app configuration  
•	Context.xml --> manage spring beans  
•	NFRs(Non-Functional Requirements) --> implement non functional requirement  
•	Aşağıdaki ifade belirli bir işlem tamamlandıktan sonra kullanıcıyı belirli bir URL'e(list-todos) yönlendirme yapmak için kullanılır.  
```java
return "redirect:/path" 
return "redirect:list-todos" 
```  
•	**BindingResult**, @Valid anotasyonu ile doğrulama işleminden sonra oluşan hataları tutar. Doğrulama hatalarına ilişkin ayrıntılı mesajlar sağlar. Verilerin bağlanması sırasında(örneğin, formdan gelen verilerin model nesnelerine dönüştürülmesi) oluşan hataları da içerir.  

### Log Level 
•	Log level sıralaması;
	**OFF - FATAL - ERROR- WARN - INFO - DEBUG - TRACE - ALL ** 
•	**OFF** tamamen bütün logların kapalı olduğu, ALL bütün loğların açık olduğu log seviyesidir.  
• 	**Trace** en detaylı bilgilerin verildiği log seviyesidir. Bu log seviyesinde harici ir log dosyası kullanımı gereklidir.   
•	**Debug** yazılımcıların en çok kullanıdığı log seviyesidir.  
•	**Info** genellikle son kullanıcılar tarafından kullanılan log seviyesidir.   
•	**Fatal** uygulamada kalıcı bir hata, çökme tehlikesi olan durumlarda basılmalıdır.    
•	Eğer bir log seviyesi tanımlarsak; tanımladığımız log seviyesi ve üzerindeki loglar görülebilirken altındakiler görülmez. Örnek; log seviyesi error ise off,
 fatal ve error seviyesi loğlar görülebilecek ancak diğer loğlar görülemeyecektir.   

### Git Komutları
•	**Fast Forward Merge:** Bu işlemin yapılabilmesi için local brancimizin commit geçmişi remote branchimizin geçmişinin bir alt geçmişi olmalıdır. 
```git
	git pull --ff-only
```
•	**git pull --rebase**; Remote branchteki değişiklikleri local brachimize çeker ve aynı zamanda local commit geçmişimizi yeniden yazar. Sadece local commit geçmişimizi etkiler, remote geçmişini etkilemez. 

•	**git rebase --abort**; halihazırda devam eden git rebase işlemini iptal etmek için kullanılır. Daha önce yeniden yazılmış commitler silinir ve local branch'imizin geçmişi, rebase işlemi başlamadan önceki haline getirilir. Yalnızca devam eden rebase işlemini iptal eder.. Tebase işlemi tamamlandıktan sonra kullanılamaz. 

•	**git clone URL**; remote bir depoda bulunan bir Git repositoryisi üzerinde çalışmak için local makinemize indirmemizi sağlar. 
```git
	git clone https://github.com/SedaGUNEYDURAN/ToDo-App.git
```
