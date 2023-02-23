from django.urls import path, include
from rest_framework import routers
from .views import BarViewSet, AtraccionViewSet, ComentarioViewSet


router = routers.DefaultRouter()
router.register(r'bares', BarViewSet)
router.register(r'atracciones', AtraccionViewSet)
router.register(r'comentarios', ComentarioViewSet)

from . import views

urlpatterns = [
    path('api/', include(router.urls)),
]