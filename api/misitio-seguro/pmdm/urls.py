from django.urls import path, include
from rest_framework import routers
from .views import BarViewSet, AtraccionViewSet, ComentarioViewSet, PeliculaViewSet, ActorViewSet, IngredienteViewSet


router = routers.DefaultRouter()
router.register(r'bares', BarViewSet)
router.register(r'atracciones', AtraccionViewSet)
router.register(r'comentarios', ComentarioViewSet)
router.register(r'peliculas', PeliculaViewSet)
router.register(r'actores', ActorViewSet)
router.register(r'ingrediente', IngredienteViewSet)

from . import views

urlpatterns = [
    path('api/', include(router.urls)),
]