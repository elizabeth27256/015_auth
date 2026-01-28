Proyecto: Autenticación y Autorización con AWS Cognito
Este proyecto demuestra cómo proteger una API usando AWS Cognito, implementando tres niveles de acceso:

/api/public → acceso libre, sin necesidad de token.

/api/restricted → acceso solo para usuarios autenticados.

/api/restricted/admin → acceso exclusivo para usuarios autenticados que pertenecen al grupo admin.

🚀 Requisitos
Java 21

Gradle

Cuenta de AWS con Cognito configurado

Postman (para pruebas de los endpoints)

⚙️ Configuración
Clona el repositorio:
https://github.com/elizabeth27256/015_auth.git

Configura el archivo application.yml con los datos de Cognito:

Región de AWS

ID del User Pool

Enlace del issuer-uri

Asegúrate de que tu Identity Pool esté enlazado con el User Pool y que tengas un grupo admin creado en Cognito.

▶️ Ejecución
Ejecuta el proyecto con Gradle:

Código
./gradlew bootRun
La API estará disponible en:

Código
http://localhost:8080/api


🔑 Endpoints
1. Público
URL: /api/public

Acceso: Libre, sin token

Resultado esperado: 200 OK

2. Restringido
URL: /api/restricted

Acceso: Requiere token válido

Resultado esperado:

Sin token: 401/403

Con token: 200 OK

3. Admin
URL: /api/restricted/admin

Acceso: Requiere token válido y pertenecer al grupo admin

Resultado esperado:

Usuario normal: 403 Forbidden

Usuario admin: 200 OK

