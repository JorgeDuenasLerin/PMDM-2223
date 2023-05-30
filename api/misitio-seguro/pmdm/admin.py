from django.contrib import admin

# Register your models here.
from .models import Atraccion, Bar, Comentario, Pelicula, Actor, Ingrediente, Resultado

class ComentarioInline(admin.StackedInline):
    model = Comentario
    extra = 3


class AtraccionAdmin(admin.ModelAdmin):
    model = Atraccion
    inlines = [ComentarioInline]


admin.site.register(Atraccion, AtraccionAdmin)
admin.site.register(Bar)


class ActorInline(admin.StackedInline):
    model = Actor
    extra = 5


class PeliculaAdmin(admin.ModelAdmin):
    model = Pelicula
    inlines = [ActorInline]


admin.site.register(Pelicula, PeliculaAdmin)
admin.site.register(Actor)
admin.site.register(Ingrediente)



class ResultadoAdmin(admin.ModelAdmin):
    model = Resultado


admin.site.register(Resultado, ResultadoAdmin)