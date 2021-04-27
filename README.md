# Proyecto convocatorias

## Supuestos sobre el problema

### Asumiendo

_Esta sección está abierta a correcciones y no es el resultado final de nada, sólo una lluvia de ideas para intentar delimitar el problema._

* Una convocatoria es un medio utilizado para convocar a un grupo de
personas para que asistan a determinado lugar o evento. En este caso, las
convocatorias son dirigidas a los estudiantes y realizadas por una
institución de educación superior. Se intuye que el evento o motivo detrás de
una convocatoria particular puede estar relacionado con algún proyecto de
investigación (publicar los resultados, reclutar estudiantes interesados,
buscar patrocinio) promoción de becas, presentación de
un programa, entre otros. **se asume que los detalles sobre el evento
específico detrás de la convocatoria no son realmente relevantes, como por
ejemplo el patrocinador**.

* El propósito de una convocatoria es llamar la atención de un grupo de
personas sobre un suceso particular en un momento específico. Con eso en
cuenta, una convocatoria tiene un título o nombre, un asunto (descripción muy
corta a manera de slogan, describe sobre qué trata y a qué se planea llegar
con ella) una imagen de portada para orientar y llamar la atención del
participante, una descripción más elaborada de los puntos y propósitos detrás
del evento promocionado, una serie de premios (opcionalmente) que pueden o no
incluir un monto monetario, y unas fechas de inicio y de cierre. (se
especifica y tiene muy en cuenta la la zona horaria).

* Una convocatoria puede estar dividida en una o varias etapas dependiendo de
la naturaleza del evento detrás, por obligación una etapa no puede extenderse
por fuera de los límites de la fecha de cierre de una convocatoria. Para cada
etapa se designan unos instantes (fecha y hora) de inicio y de cierre,
intervalos de tiempos que se delimitan en días independientemente de la
duración de la etapa, y sólo puede ocurrir una etapa a la vez por días (por
ejemplo, una convocatoria de 8hs puede dividirse en 4 etapas de 2hs de
duración, pero cada etapa debe realizarse en un día diferente).

### De primera mano

* Un estudiante que esté interesado en entrar a una o varias convocatorias
necesita iniciar sesión con un usuario válido, si intenta inscribirse en una
convocatoria se le redigirá a un formulario donde se le de la opción de crear
uno (y un elemento adicional en la interfaz que le indique la opción de
loguearse si ya posee uno). _Los datos que debe suministrar un usuario para
inscribirse aparte de los básicos (nombre, correo, programa, semestre, fecha
de nacimiento) no son claros todavía._

* Además una convocatoria posee una serie de requisitos, los cuales deben ser
aprobados para poder participar en ella (no se sabe exactamente qué criterios
de evaluación deben pasar - se ignora - o quién los evalúa - de momento
asumimos que es el administrador -) esos requisitos pueden ser la misma
información que provee el perfil del usuario creado, o pueden ser documentos
externos, lo importante es cada convocatoria que aún esté aceptando
inscripciones tiene que tener su propio formulario de requisitos, cada
convocatoria puede pedir requisitos diferentes; se asume que **es posible que
un usuario NO cumpla con los requisitos para inscribirse a una convocatoria
particular, en cuyo caso su información debe ser descartada,** y que **una convocatoria no acepta más postulaciones de
aspirantes a partir de cierto punto por temas de logística (por ejemplo, faltando 8 días para que inicie)**
