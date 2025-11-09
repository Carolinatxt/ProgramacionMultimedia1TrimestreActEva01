# Actividad Evaluable 01 - Aplicación Android

### Proyecto del módulo **Programación Multimedia y Dispositivos Móviles (PMDM)**
**Ciclo:** 2º DAM – Desarrollo de Aplicaciones Multiplataforma  
**Centro:** PRO2FP  
**Autora:** Carolina de la Losa  
**Curso académico:** 2025 – 2026  
**Versión:** 1.0

---

## Descripción general

**ActEva01** es una aplicación Android nativa desarrollada en **Kotlin** con diseño en **XML**, que implementa tres pantallas interactivas conectadas mediante `Intent` explícitos.

La app demuestra el dominio de conceptos fundamentales:
- Navegación entre pantallas usando Intents
- Validaciones robustas de formularios
- Diseño visual adaptativo con ConstraintLayout
- Implementación de buenas prácticas en Kotlin

### Pantallas de la aplicación:

| Activity | Descripción |
|----------|-------------|
| **MainActivity** | Pantalla inicial con logo, nombre, eslogan y botón de navegación. |
| **PresentationActivity** | Información personal (nombre, edad, descripción) con botón al formulario. |
| **FormActivity** | Formulario de contacto con validaciones, mensajes de error y confirmaciones. |

---

## Requisitos técnicos

| Componente | Requisito |
|------------|-----------|
| **IDE** | Android Studio Arctic Fox o superior |
| **Lenguaje** | Kotlin |
| **Diseño** | XML con ConstraintLayout |
| **View Binding** | Habilitado |
| **SDK mínimo** | API 24 – Android 7.0 |
| **SDK objetivo** | API 34 – Android 14 |

---

## Cómo abrir y ejecutar el proyecto

### Requisitos Previos
- Android Studio Arctic Fox o superior
- JDK 8 o superior
- Conexión a Internet (para dependencias)

### Instalación

#### 1. Descargar el Proyecto
- Clona el repositorio o descarga el ZIP
- Descomprime en una carpeta de tu elección

#### 2. Abrir en Android Studio
1. Inicia Android Studio
2. `File → Open`
3. Selecciona la carpeta raíz del proyecto
4. Haz clic en **OK**

#### 3. Sincronizar Gradle
- Android Studio sincronizará automáticamente
- Espera 2-5 minutos (primera vez)
- Si no se inicia: `File → Sync Project with Gradle Files`

#### 4. Ejecutar la Aplicación

**Opción A: Emulador**
1. `Tools → Device Manager`
2. Si no tienes emulador:
    - Clic en **Create Device**
    - Selecciona **Pixel 6**
    - Descarga **API 34 (Android 14)**
    - Clic en **Finish**
3. Inicia el emulador ▶️
4. Haz clic en **Run** (verde) o `Shift + F10`

**Opción B: Dispositivo físico**
1. Habilita **Opciones de desarrollador**:
    - `Ajustes → Acerca del teléfono`
    - Toca 7 veces en **Número de compilación**
2. Activa **Depuración USB**:
    - `Ajustes → Opciones de desarrollador`
    - Activa **Depuración USB**
3. Conecta con cable USB
4. Autoriza en el dispositivo
5. Clic en **Run** ▶️

#### 5. Verificar instalación
Deberías ver la pantalla principal con:
- Logo de la aplicación
- Nombre "CAROLINA DE LA LOSA"
- Eslogan "Programación multimedia"
- Botón "Ver presentación"

---

## Capturas de Pantalla

### 1. MainActivity – Pantalla Principal

`images/MainActivity.png`

**Elementos principales:**
- **Logo central**: Icono personalizado con elevación de 8dp
- **Tarjeta contenedora**: MaterialCardView semitransparente (#10FFFFFF), bordes redondeados (20dp)
- **Nombre**: "CAROLINA DE LA LOSA" en rosa suave (26sp) con sombra
- **Eslogan**: "PROGRAMACIÓN MULTIMEDIA" en mayúsculas (15sp)
- **Botón**: Degradado rojo con icono de play, esquinas redondeadas (25dp)
- **Fondo**: Color oscuro vino (#2A0000)

---

### 2. PresentationActivity – Presentación Personal

`images/PresentationActivity.png`

**Elementos principales:**
- **Título**: "Presentación personal" (24sp) con sombra
- **Avatar**: Logo 120x120dp con elevación
- **Tarjeta de información**: MaterialCardView con 3 secciones:
    - **Nombre**: Icono + "Carolina de la Losa"
    - **Edad**: Icono + "22 años"
    - **Descripción**: Texto sobre desarrollo Android y Kotlin
- **Botón**: "Ir al formulario" en rojo acento
- **ScrollView**: Desplazamiento vertical

---

### 3. FormActivity – Formulario de Contacto

`images/FormActivity.png`

**Elementos principales:**
- **Icono superior**: Email icon (56x56dp)
- **Título**: "Formulario de contacto" (24sp)
- **Card del formulario**: Fondo semitransparente (#30FFFFFF)
- **Campos de entrada** (con iconos):
    - Nombre (textPersonName, altura 48dp)
    - Email (textEmailAddress, altura 48dp)
    - Mensaje (multilinea, 120dp)
- **Botones**:
    - "Enviar": Fondo rojo, esquinas redondeadas
    - "Limpiar": Estilo outlined con borde rojo
- **TextView confirmación**: Oculto por defecto

---

### 4. FormActivity – Confirmación de Envío

`images/FormEnviado.png`

**Comportamiento tras envío exitoso:**
- **Toast**: "Mensaje enviado correctamente ✉️"
- **TextView visible**: "Gracias [nombre], su formulario se ha enviado correctamente"
- **Campos limpiados**: Todos los EditText vacíos
- **Fondo confirmación**: Semitransparente con borde rosa

---

## Validaciones del Formulario

### 1. Validación de Campos Vacíos

**Implementación:**
```kotlin
private fun validarFormulario(): Boolean {
    val nombre = ui.edNombre.text.toString().trim()
    val email = ui.edEmail.text.toString().trim()
    val mensaje = ui.edMensaje.text.toString().trim()
    var esValido = true

    if (nombre.isEmpty()) {
        ui.edNombre.error = getString(R.string.error_campo_vacio)
        esValido = false
    }
    if (email.isEmpty()) {
        ui.edEmail.error = getString(R.string.error_campo_vacio)
        esValido = false
    }
    if (mensaje.isEmpty()) {
        ui.edMensaje.error = getString(R.string.error_campo_vacio)
        esValido = false
    }
    return esValido
}
```

**Comportamiento:**
- Verifica que los tres campos contengan texto
- Usa `.trim()` para eliminar espacios
- Marca campos con `.error` si están vacíos
- Toast: "Por favor, completa todos los campos antes de enviar"

---

### 2. Validación de Formato de Email

**Implementación:**
```kotlin
if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
    ui.edEmail.error = getString(R.string.error_email_invalido_formato)
    esValido = false
}
```

**Formatos válidos:**
- ✅ usuario@gmail.com
- ✅ carolina_delosa@hotmail.com

**Formatos inválidos:**
- ❌ usuario@gmail (sin dominio)
- ❌ @gmail.com (sin usuario)
- ❌ usuario.gmail.com (sin @)

**Mensaje de error:**
"Introduce un correo válido, por ejemplo: usuario@dominio.com"

---

### 3. Feedback al Usuario

**Al validar correctamente:**
```kotlin
ui.btnEnviar.setOnClickListener {
    if (validarFormulario()) {
        val nombre = ui.edNombre.text.toString().trim()
        ui.tvConfirmacion.text = "Gracias $nombre, su formulario se ha enviado correctamente."
        ui.tvConfirmacion.visibility = View.VISIBLE
        Toast.makeText(this, getString(R.string.toast_enviado), Toast.LENGTH_SHORT).show()
    } else {
        Toast.makeText(this, getString(R.string.toast_campos_incompletos), Toast.LENGTH_SHORT).show()
    }
}
```

**Tipos de feedback:**
- ✅ Toast de éxito: "Mensaje enviado correctamente ✉️"
- ✅ TextView personalizado con nombre del usuario
- ❌ EditText.error en campos con problemas
- ❌ Toast de error general

---

### 4. Botón Limpiar

**Implementación:**
```kotlin
ui.btnLimpiar.setOnClickListener {
    ui.edNombre.text?.clear()
    ui.edEmail.text?.clear()
    ui.edMensaje.text?.clear()
    ui.tvConfirmacion.visibility = View.GONE
    Toast.makeText(this, getString(R.string.toast_campos_limpiados), Toast.LENGTH_SHORT).show()
}
```

---

## Estructura del Proyecto

```plaintext
ActEva01/
├── app/src/main/
│   ├── java/com/example/acteva01/
│   │   ├── MainActivity.kt
│   │   ├── PresentationActivity.kt
│   │   └── FormActivity.kt
│   ├── res/
│   │   ├── layout/
│   │   │   ├── activity_main.xml
│   │   │   ├── activity_presentation.xml
│   │   │   └── activity_form.xml
│   │   ├── values/
│   │   │   ├── colors.xml
│   │   │   ├── strings.xml
│   │   │   └── themes.xml
│   │   ├── drawable/
│   │   │   ├── bg_input_field.xml
│   │   │   ├── bg_confirmacion.xml
│   │   │   └── button_gradient.xml
│   │   └── mipmap/
│   │       └── ic_launcher.png
│   └── AndroidManifest.xml
└── images/
    ├── MainActivity.png
    ├── PresentationActivity.png
    ├── FormActivity.png
    └── FormEnviado.png
```

---

## Diseño y Estilos

### Paleta de Colores

```xml
<color name="fondo_principal">#2A0000</color>      <!-- Fondo oscuro -->
<color name="rojo_acento">#D12C2C</color>          <!-- Botones -->
<color name="rojo_claro">#E53935</color>           <!-- Acentos -->
<color name="rosa_suave">#F8AFAF</color>           <!-- Textos -->
<color name="blanco">#FFFFFF</color>               <!-- Texto botones -->
```

---

### Drawables Personalizados

**button_gradient.xml** (Degradado rojo):
```xml
<gradient
    android:angle="135"
    android:startColor="#E53935"
    android:endColor="#B71C1C"/>
<corners android:radius="25dp"/>
```

**bg_input_field.xml** (Campos de entrada):
```xml
<stroke android:width="1dp" android:color="@color/rosa_suave"/>
<corners android:radius="12dp"/>
```

**bg_confirmacion.xml** (Mensaje de éxito):
```xml
<solid android:color="#20FFFFFF"/>
<stroke android:width="1dp" android:color="@color/rosa_suave"/>
<corners android:radius="12dp"/>
```

---

## Extras Implementados para Nota Alta

### 1. ConstraintLayout en todos los layouts
- MainActivity, PresentationActivity, FormActivity
- Posicionamiento flexible sin layouts anidados

### 2. Archivo colors.xml personalizado
- 8 colores definidos con nombres semánticos
- Paleta coherente rojo/rosa sobre fondo oscuro

### 3. Archivo themes.xml personalizado
- Tema Material3 personalizado
- Splash screen configurado
- Status bar y navigation bar personalizados

### 4. Drawables personalizados (3 archivos XML)
- button_gradient.xml (degradado para botón)
- bg_input_field.xml (fondo campos)
- bg_confirmacion.xml (fondo confirmación)

### 5. Icono de aplicación personalizado
- ic_launcher.png en mipmap
- Visible en launcher y pantallas

### 6. Material Design Components
- MaterialCardView, MaterialButton
- Ripple effects y elevaciones

### 7. ViewBinding habilitado
```kotlin
private lateinit var ui: ActivityFormBinding
ui = ActivityFormBinding.inflate(layoutInflater)
setContentView(ui.root)
```

### 8. Strings externalizados
- 30+ strings en strings.xml
- Sin textos hardcodeados

### 9. Comentarios extensos
- XML comentado por secciones
- Kotlin con comentarios explicativos

### 10. Accesibilidad
- contentDescription en ImageView
- minHeight 48dp en campos táctiles
- autofillHints e inputType apropiados

---

## Solución de Problemas

### Problema 1: App no se instala
**Solución:**
- Verifica que el emulador esté iniciado
- `Tools → Device Manager` → Inicia emulador
- Espera 1-2 minutos a que arranque

### Problema 2: Errores de Gradle
**Solución:**
- `File → Sync Project with Gradle Files`
- `Build → Clean Project`
- `Build → Rebuild Project`

### Problema 3: ViewBinding no reconocido
**Solución:**
- Verifica en `build.gradle.kts`:
```kotlin
buildFeatures {
    viewBinding = true
}
```
- Sincroniza Gradle
- `Build → Rebuild Project`

### Problema 4: Icono no aparece
**Solución:**
- Verifica que existe: `res/mipmap/ic_launcher.png`
- Desinstala app del dispositivo/emulador
- Vuelve a ejecutar

---

## Dependencias

```kotlin
dependencies {
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
}
```

---

## Autora

**Nombre:** Carolina de la Losa
**Ciclo:** 2º DAM  
**Centro:** PRO2FP  
**Módulo:** PMDM  
**Curso:** 2025 – 2026

---

## Notas Adicionales

- Compatible con Android 7.0 y superior
- Sin permisos especiales requeridos
- Datos no persisten (solo en memoria)
- Diseño responsive para diferentes pantallas
- Strings preparados para internacionalización

---

## Recursos Utilizados

- [Android Developers - Kotlin](https://developer.android.com/kotlin)
- [Material Design 3](https://m3.material.io/)
- [ConstraintLayout Guide](https://developer.android.com/develop/ui/views/layout/constraint-layout)

---

**Versión:** 1.0  
**Fecha:** Octubre 2025 
**Licencia:** Uso educativo - PMDM 2º DAM

---

