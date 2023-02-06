from django.shortcuts import render
from django.http import HttpResponse
from rest_framework import permissions

def index(request):
    return HttpResponse("Hola mundo de los APIs.")

from rest_framework import viewsets
from .models import Question, Choice
from .serializers import QuestionDetailSerializer, QuestionListSerializer, ChoiceSerializer


class QuestionViewSet(viewsets.ModelViewSet):
    queryset = Question.objects.all()
    serializer_class = QuestionListSerializer
    permission_classes = [permissions.IsAuthenticated]

    def get_serializer_class(self):
        if self.action == 'retrieve':
            return QuestionDetailSerializer
        else: 
            return QuestionListSerializer


class ChoiceViewSet(viewsets.ModelViewSet):
    queryset = Choice.objects.all()
    serializer_class = ChoiceSerializer
    permission_classes = [permissions.IsAuthenticated]