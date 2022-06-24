from django.http import JsonResponse
from rest_framework.views import APIView
from rest_framework.parsers import JSONParser
from django.contrib.auth import authenticate, login


class LoginView(APIView):
    def post(self, request):
        data = JSONParser().parse(request)
        user = authenticate(request, username=data['email'], password=data['password'])

        if user is not None:
            login(request, user)
            res = {
                'success': True
            }
            return JsonResponse(res)

        else:
            res = {
                'success': False
            }
            return JsonResponse(res)
