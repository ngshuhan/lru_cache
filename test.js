
var expect = chai.expect;

describe('LruCache',function() {

	var cache = new LruCache(5);


	describe("constructor",function() {
	
		it("should have an empty array upon defined",function() {
			expect(cache.keys).to.be.empty;
		});

		it("should have a maximum size as defined",function() {
			expect(cache.limit).to.equal(5);

		});
	});

	describe("#put",function() {
		it("should put a key value pair to the cache",function() {
			cache.put("adam",29);
			expect(cache.pairs).to.deep.equal({"adam":29});
		});
		it("should keep on adding key value pair when cache is not full",function() {
			cache.put("john",26);
			cache.put("angela",24);
			cache.put("mike",35);
			cache.put("wen",15);
			expect(cache.pairs).to.deep.equal({"adam":29,"john":26,"angela":24,"mike":35,"wen":15});

		});
		it("should remove the oldest item when the cache is full",function() {
			cache.put("susanna",24);
			console.log(cache);
			expect(cache.pairs).to.deep.equal({"john":26,"angela":24,"mike":35,"wen":15,"susanna":24});
		})
	});
	describe("#remove",function() {
		it("should remove the item and return its associated value from the cache if it exists",function() {
			expect(cache.remove("mike")).to.equal(35);
		})
		it("should return undefine if it does not exists in the cache",function() {
			expect(cache.remove("hannah")).to.equal(35);

		})
	})


});