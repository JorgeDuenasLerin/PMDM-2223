from django.contrib import admin

# Register your models here.
from .models import Atraccion, Bar, Comentario

class ComentarioInline(admin.StackedInline):
    model = Comentario
    extra = 3


class AtraccionAdmin(admin.ModelAdmin):
    model = Atraccion
    inlines = [ComentarioInline]

admin.site.register(Atraccion, AtraccionAdmin)
admin.site.register(Bar)