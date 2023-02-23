from django.contrib.auth.models import User, Group
from rest_framework import serializers
from .models import Atraccion, Bar, Comentario


class BarSerializer(serializers.HyperlinkedModelSerializer):

   class Meta:
        model = Bar
        fields = '__all__'


class ComentarioSerializer(serializers.HyperlinkedModelSerializer):

   class Meta:
        model = Comentario
        fields = '__all__'


class AtraccionDetailSerializer(serializers.HyperlinkedModelSerializer):
    comentarios=ComentarioSerializer(many=True)

    class Meta:
        model = Atraccion
        fields = '__all__'


class AtraccionListSerializer(serializers.HyperlinkedModelSerializer):
    class Meta:
        model = Atraccion
        fields = '__all__'
