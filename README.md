# spring-gcp-api-rest

Requierments:

- App engine instancie active
- Instance of cloud data store active in the same project as the app engine
- Google sdk install 
- maven 
- java 11


Instructions to deploy api

- gcloud auth application-default login ( to authenticate your account)

- Execute this command to see the projects you have and copy the one you want to deploy the api:  gcloud config list project

- Set your project id in your console:  gcloud config set project <PROJECT_ID>

- mvn compile  (to build the project)

- mvn spring-boot:run  (to run locally)

- When you stopped your local instance and you want to deploy it in app engine if it's active and it has a cloud data store also active in the same project it will work:

mvn -DskipTests package appengine:deploy(this don't run tests)



Paths availables:

- Get "/"  ->  return "hello world!"
	 
- Post "/add" with Content-Type application/json  and body:
 {
"macAdress": "12:61:67:11:56:11",
"timestamp": "12-10-2021"

} -> Dont return any significative value
(Adds a device)


- Post "/test" with Content-Type application/json ->  return "test post"

- Get -> "/getDevices" -> return list of  all devices
    
- Get "/getDeviceByMacAdress" with macAdress of param and value 78:61:56:11:56:11 -> returns the device with the mac adress
   
- Get "/getDeviceById" param id value  5642368648740864 -> return a device  
   
- Get "/crosscheck"  with id param -> return  crosscheck done!" + id;

- Delete "/deleteDevice" with body id -> deletes a device
    
    

# This project is running in this domain so you can try the api,feel free to test.

 https://my-project-61756.uc.r.appspot.com/
	
	
	

	
	

 