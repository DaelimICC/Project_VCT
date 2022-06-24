from django.http import JsonResponse
from rest_framework.views import APIView
from django.contrib.auth import logout


class LogOutView(APIView):
    def post(self, request):
        logout(request)
        res = {
            'success': True
        }
        return JsonResponse(res)
