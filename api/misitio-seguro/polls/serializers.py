from django.contrib.auth.models import User, Group
from rest_framework import serializers
from .models import Question, Choice


class ChoiceSerializer(serializers.HyperlinkedModelSerializer):
    question=serializers.PrimaryKeyRelatedField(queryset=Question.objects.all())
    class Meta:
        model = Choice
        fields = ['pk', 'choice_text', 'votes', 'question']


class QuestionDetailSerializer(serializers.HyperlinkedModelSerializer):
    choices=ChoiceSerializer(many=True)

    class Meta:
        model = Question
        fields = ['pk', 'question_text', 'pub_date', 'choices']


class QuestionListSerializer(serializers.HyperlinkedModelSerializer):
    class Meta:
        model = Question
        fields = ['pk', 'question_text', 'pub_date']
