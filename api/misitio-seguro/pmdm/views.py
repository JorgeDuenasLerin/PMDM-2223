from django.shortcuts import render
from django.http import HttpResponse
from rest_framework import permissions
import django_filters.rest_framework

# Create your views here.
from rest_framework import viewsets
from .models import Bar, Atraccion, Comentario
from .serializers import BarSerializer, AtraccionListSerializer, AtraccionDetailSerializer, ComentarioSerializer


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