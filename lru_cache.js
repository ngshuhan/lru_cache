(function(exports) {
	"use strict";

	function LruCache(limit) {
		this.limit = limit;
		this.keys = [];
		this.pairs = {}; 
	}
	exports.LruCache = LruCache;

	LruCache.prototype = {
		put: function(key,value) {
			if (this.keys.length >= this.limit) { //the cache is full
				let key = this.keys[0];
				delete this.pairs[key];
				this.keys.shift();
			}
			this.keys.push(key);
			this.pairs[key] = value;
		}, 

		remove: function(key) {
			var keys = this.keys;
			var index = keys.indexOf(key);
			var value = this.pairs[key];
			if (index > -1 ) {
				keys.splice(index,1);
				delete this.pairs[key];
			}
			return value;
		},

		removeAll: function() {
			this.keys = [];
			this.pairs = {};
		},

		get : function(key) {
			var keys = this.keys;
			var index = keys.indexOf(key);
			var value = this.pairs[key];
			if (index > -1 ) {
				keys.splice(index,1);
				keys.push(key);
			}
			return value;
		}

	};
})(this);






