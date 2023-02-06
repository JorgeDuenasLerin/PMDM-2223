from django.urls import path, include
from rest_framework import routers
from polls import views
from rest_framework.authtoken import views as viewsfr

router = routers.DefaultRouter()
router.register(r'question', views.QuestionViewSet)
router.register(r'choice', views.ChoiceViewSet)


from . import views

urlpatterns = [
    path('', views.index, name='index'),
    path('api/', include(router.urls)),
    path('api-token-auth/', viewsfr.obtain_auth_token),
]
