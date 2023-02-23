from django.urls import path, include
from rest_framework import routers
from polls import views


router = routers.DefaultRouter()
router.register(r'question', views.QuestionViewSet)
router.register(r'choice', views.ChoiceViewSet)


from . import views

urlpatterns = [
    path('', views.index, name='index'),
    path('api/', include(router.urls)),
]
