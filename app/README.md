# Actividad Evaluable 01 - Aplicación Android

### Proyecto del módulo **Programación Multimedia y Dispositivos Móviles (PMDM)**
**Ciclo:** 2º DAM – Desarrollo de Aplicaciones Multiplataforma  
**Centro:** PRO2FP  
**Autora:** 
**Curso académico:** 2025 – 2026  
**Versión:** 1.0

---

## Descripción general

**ActEva01** es una aplicación Android nativa desarrollada en **Kotlin** con diseño en **XML**, que implementa tres pantallas interactivas (Activities) conectadas mediante `Intent`.  
Su objetivo es demostrar el uso de navegación entre pantallas, validaciones de formularios y un diseño visual adaptativo personalizado mediante recursos XML.

La app está compuesta por tres pantallas principales:

| Activity | Descripción                                                                                                                    |
|-----------|--------------------------------------------------------------------------------------------------------------------------------|
| **MainActivity** | Pantalla inicial con logo, nombre, eslogan y un botón que lleva a la presentación personal.                                    |
| **PresentationActivity** | Muestra información personal (nombre, edad y descripción) y dispone de un botón que permite acceder al formulario de contacto. |
| **FormActivity** | Pantalla con un formulario de contacto con validaciones completas, mensajes de error, confirmaciones visuales y informativas.  |

---

## Requisitos técnicos

| Componente | Requisito |
|-------------|------------|
| **IDE** | Android Studio Arctic Fox o superior |
| **Lenguaje** | Kotlin |
| **Diseño** | XML con `ConstraintLayout` |
| **Compatibilidad mínima** | SDK 21 – Android 5.0 Lollipop |
| **Compatibilidad máxima** | SDK 34 – Android 14 |
| **Dispositivos compatibles** | Teléfonos y tablets |

---

## Cómo abrir y ejecutar el proyecto

1. **Clonar o descargar el proyecto**
    - Desde GitHub o mediante un archivo .zip.
2. **Abrir en Android Studio**
    - `File → Open` → selecciona la carpeta del proyecto.
3. **Esperar la sincronización de Gradle**
    - Android Studio descargará las dependencias automáticamente.
4. **Ejecutar**
    - Usa un emulador (`Pixel 6 / API 34`) o un dispositivo físico con depuración USB activada.
5. **Resultado**
    - Al ejecutarse, se abrirá la pantalla principal con el logo, el nombre y el botón “Ver presentación”.

---

## Capturas de pantalla

### MainActivity – Pantalla principal
- `images/MainActivity.png`

---

### PresentationActivity – Presentación personal
- `images/PresentationActivity.png`

---

### FormActivity – Formulario de contacto
- `images/FormActivity.png`

---

### Confirmación de envío
- `images/FormEnviado.png`

---

## Lógica general de la aplicación

### Flujo de navegación

MainActivity → PresentationActivity → FormActivity

1. Desde **MainActivity**, el botón “Ver presentación” abre la pantalla de presentación.
2. En **PresentationActivity**, el botón “Ir al formulario” redirige al formulario.
3. En **FormActivity**, el usuario completa los campos, valida y recibe feedback visual y auditivo.
4. Todo el flujo se gestiona mediante Intents explícitos para cambiar de pantalla.

---

### Validaciones del formulario
| Campo | Requisitos | Comportamiento en error |
|--------|-------------|--------------------------|
| **Nombre** | Obligatorio (no puede estar vacío). | Se marca con `EditText.error` (“Campo obligatorio”). |
| **Correo electrónico** | Obligatorio y formato válido (`usuario@dominio.com`). | Se marca con `EditText.error` mostrando “Introduce un correo válido (ejemplo@correo.com)”. |
| **Mensaje** | Obligatorio (no puede estar vacío). | Se marca con `EditText.error`. |

**Si hay errores:**
- El campo correspondiente se marca en rojo.
- Aparece un Toast general:
  > “Por favor, completa todos los campos antes de enviar.”

**Si todo es correcto:**
- Se muestra el mensaje:
  > “Gracias [nombre], su formulario se ha enviado correctamente.”
- Se activa un Toast:
  > “Mensaje enviado correctamente”
- El `TextView` de confirmación se hace visible con fondo decorativo.

### Botón “Limpiar”
- Borra el contenido de los tres campos.
- Oculta el mensaje de confirmación.
- Muestra el Toast:
  > “Campos limpiados correctamente.”

---
## Estructura
```plaintext
app/
├── java/com/example/acteva01/
│   ├── MainActivity.kt
│   ├── PresentationActivity.kt
│   └── FormActivity.kt
├── res/
│   ├── layout/
│   │   ├── activity_main.xml
│   │   ├── activity_presentation.xml
│   │   └── activity_form.xml
│   ├── values/
│   │   ├── colors.xml
│   │   ├── strings.xml
│   │   └── themes.xml
│   ├── drawable/
│   │   ├── bg_input_field.xml
│   │   ├── bg_confirmacion.xml
│   │   └── button_gradient.xml
│   └── mipmap/
│       └── ic_launcher.png
```

## Diseño y estilos

### Layouts
- Todos los layouts usan **ConstraintLayout** para garantizar una distribución adaptable.
- En el formulario, se usa un **ScrollView** para permitir desplazamiento en pantallas pequeñas.
- Cada pantalla tiene su propio diseño XML independiente.

### Colores utilizados (`colors.xml`)
| Color | Nombre de recurso | Descripción |
|-------|-------------------|--------------|
| #2A0000 | `fondo_principal` | Fondo oscuro principal |
| #D12C2C | `rojo_acento` | Color principal de botones |
| #E53935 | `rojo_claro` | Acentos y divisores |
| #F8AFAF | `rosa_suave` | Textos destacados |
| #FFFFFF | `blanco` | Textos sobre fondo oscuro |

### Fuentes y estilo visual
- Tipografía base: `sans-serif` y `sans-serif-light`.
- Se aplican sombras suaves en títulos y elementos destacados.
- Los botones se construyen con **MaterialButton** (estilo `contained` y `outlined`).
- Los contenedores usan **MaterialCardView** con esquinas redondeadas.

---

## Temas y compatibilidad
- Tema base: `Theme.Material3.DayNight.NoActionBar`.
- Se incluyen archivos `themes.xml` y `themes.xml (night)` para soportar modo oscuro.
- Los colores se mantienen coherentes entre pantallas, garantizando consistencia visual.

---

**Versión:** 1.0  
**Última actualización:** Noviembre 2025  
**Propósito:** Actividad evaluable 01 – Aplicación Android (PMDM – 2º DAM)





