from django.urls import path
from .views import UserView


urlpatterns =[
    path('', UserView.as_view()),
    path('<str:user_Id>', UserView.as_view())
]