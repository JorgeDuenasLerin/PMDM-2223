from django.shortcuts import render
from django.http import HttpResponse
from rest_framework import permissions
import django_filters.rest_framework

# Create your views here.
from rest_framework import viewsets
from .models import Bar, Atraccion, Comentario
from .models import Actor, Pelicula, Ingrediente, Resultado
from .serializers import BarSerializer, AtraccionListSerializer, AtraccionDetailSerializer, ComentarioSerializer, ResultadoListSerializer
from .serializers import ActorSerializer, PeliculaDetailSerializer, PeliculaListSerializer
from .serializers import IngredienteListSerializer, IngredienteDetalleSerializer

class BarViewSet(viewsets.ModelViewSet):
    queryset = Bar.objects.all()
    serializer_class = BarSerializer
    filter_backends = [django_filters.rest_framework.DjangoFilterBackend]
    search_fields = ['descripcion']
    filterset_fields = ['estrellas']


class ComentarioViewSet(viewsets.ModelViewSet):
    queryset = Comentario.objects.all()
    serializer_class = ComentarioSerializer


class AtraccionViewSet(viewsets.ModelViewSet):
    queryset = Atraccion.objects.all()
    serializer_class = AtraccionListSerializer

    def get_serializer_class(self):
        if self.action == 'retrieve':
            return AtraccionDetailSerializer
        else: 
            return AtraccionListSerializer


class ActorViewSet(viewsets.ModelViewSet):
    queryset = Actor.objects.all()
    serializer_class = ActorSerializer


class PeliculaViewSet(viewsets.ModelViewSet):
    queryset = Pelicula.objects.all()
    serializer_class = PeliculaListSerializer

    def get_serializer_class(self):
        if self.action == 'retrieve':
            return PeliculaDetailSerializer
        else: 
            return PeliculaListSerializer

from rest_framework import filters
import time

class IngredienteViewSet(viewsets.ModelViewSet):
    queryset = Ingrediente.objects.all()
    serializer_class = IngredienteListSerializer
    filter_backends = [filters.SearchFilter]
    search_fields = ['tags']

    def get_queryset(self):
        time.sleep(2)
        return self.queryset

    def get_serializer_class(self):
        if self.action == 'retrieve':
            return IngredienteDetalleSerializer
        else: 
            return IngredienteListSerializer


class ResultadoViewSet(viewsets.ModelViewSet):
    queryset = Resultado.objects.all()
    serializer_class = ResultadoListSerializer