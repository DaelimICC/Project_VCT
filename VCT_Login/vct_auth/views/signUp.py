from django.http import JsonResponse
from rest_framework.views import APIView
from vct_auth.models import User
from rest_framework.parsers import JSONParser


class SignUpView(APIView):
    def post(self, request):
        data = JSONParser().parse(request)
        User.objects.create_user(
            email=data['email'],
            password=data['password'],
            nick=data['nick'],
            phone=data['phone']
        )
        res = {
            'success': True
        }
        return JsonResponse(res)
