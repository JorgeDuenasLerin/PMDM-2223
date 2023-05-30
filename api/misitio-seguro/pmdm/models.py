from django.db import models

# Create your models here.

class Bar(models.Model):
    nombre = models.CharField(max_length=200)
    descripcion = models.CharField(max_length=200)
    cierre = models.DateTimeField('Cierre')
    apertura = models.DateTimeField('Apertura')
    estrellas = models.IntegerField(default=0)

    def __str__(self):
        return self.nombre


class Atraccion(models.Model):
    nombre = models.CharField(max_length=200)
    descripcion = models.CharField(max_length=200)
    ocupantes = models.IntegerField(default=0)

    def __str__(self):
        return self.nombre


class Comentario(models.Model):
    atraccion = models.ForeignKey(Atraccion, on_delete=models.CASCADE, related_name='comentarios')
    texto = models.CharField(max_length=200)
    
    def __str__(self):
        return self.texto


class Pelicula(models.Model):
    nombre = models.CharField(max_length=200)
    descripcion = models.CharField(max_length=200)
    estrellas = models.IntegerField(default=0)

    def __str__(self):
        return self.nombre


class Actor(models.Model):
    pelicula = models.ForeignKey(Pelicula, on_delete=models.CASCADE, related_name='actores')
    nombre = models.CharField(max_length=200)
    
    def __str__(self):
        return self.nombre


class Ingrediente(models.Model):
    nombre = models.CharField(max_length=200)
    descripcion = models.CharField(max_length=200)
    tags = models.CharField(max_length=255)
    kcalorias = models.IntegerField(default=0)

    def __str__(self):
        return self.nombre