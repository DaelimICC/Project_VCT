from django.contrib.auth.mixins import LoginRequiredMixin
from django.http import JsonResponse
from rest_framework import status
from rest_framework.views import APIView
from django.contrib.auth import logout


class LogOutView(LoginRequiredMixin, APIView):
    login_url = '/auth/login'

    def post(self, request):
        logout(request)
        res = {
            'success': True
        }
        return JsonResponse(res, status=status.HTTP_200_OK)
